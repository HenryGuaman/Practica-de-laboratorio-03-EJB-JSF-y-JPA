package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;
import java.util.stream.Collectors;
import static java.lang.String.valueOf;
import ec.edu.ups.entidades.Category;
import ec.edu.ups.entidades.Product;

@Stateless
public class ProductFacade extends AbstractFacade<Product>{

    @PersistenceContext(unitName = "Practica_de_laboratorio_03_EJB_JSF_JPA")
    private EntityManager entityManager;
    
    public ProductFacade(){
        super(Product.class);
        this.entityManager = this.entityManager;
    }   

    public Product buscarProducto(String nombre){

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> usuarioRoot=criteriaQuery.from(Product.class);
        Predicate predicate = criteriaBuilder.equal(usuarioRoot.get("nombre"),nombre);
        criteriaQuery.select(usuarioRoot).where(predicate);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public Product buscarPrductoPorNombre(String nombre){
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery= criteriaBuilder.createQuery(Product.class);
        Root<Product> categoriaRoot= criteriaQuery.from(Product.class);
        Predicate predicate= criteriaBuilder.equal(categoriaRoot.get("nombre"),nombre);
        criteriaQuery.select(categoriaRoot).where(predicate);

        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
    public Product buscarProductoPorCodigo(String id){
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery= criteriaBuilder.createQuery(Product.class);
        Root<Product> categoriaRoot= criteriaQuery.from(Product.class);
        Predicate predicate= criteriaBuilder.equal(categoriaRoot.get("codigo"),id);
        criteriaQuery.select(categoriaRoot).where(predicate);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    protected EntityManager getEntityManager(){
        return entityManager;
    }

    public Map<String, String> getProductosPorCategoria(Category categoria){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> productoCriteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> productoRoot = productoCriteriaQuery.from(Product.class);
        productoCriteriaQuery.select(productoRoot)
                .where(
                        criteriaBuilder.equal(productoRoot.get("categoria"), categoria));

         return entityManager.createQuery(productoCriteriaQuery).getResultList()
                 .parallelStream()
                 .collect(Collectors.toMap(Product::getCodigo, Product::getNombre)).entrySet()
                 .parallelStream()
                 .collect(Collectors.toMap(entry -> valueOf(entry.getKey()), Map.Entry::getValue));
    }
    private List<Integer> codigoProductos;
    public List<Integer> getProductosPorBodega(int codigoBodega){
        codigoProductos = new ArrayList<>();
        Query query = entityManager.createNativeQuery("SELECT p FROM Producto p WHERE p.codigo =" + codigoBodega);
        List objectList = query.getResultList();
        if(!objectList.isEmpty()){
            objectList.forEach(e-> {
                codigoProductos.add(Integer.valueOf(valueOf(e)));
            });
        }
        return codigoProductos;
    }

    private List<Product> productos;
    public List<Product> getProductos(int codigoBodega, int codigoCategoria){
        productos = new ArrayList<>();
        List<Integer> codigosProducto = getProductosPorBodega(codigoBodega);
        if(!codigosProducto.isEmpty()) {
            codigosProducto.forEach(e -> productos.add(super.find(e)));
            productos = productos
                    .parallelStream()
                    .filter(producto -> producto.getCategoria().getCodigo() == codigoCategoria)
                    .collect(Collectors.toList());
            List<Product> productoList = new ArrayList<>();

            productos.forEach(p -> {
                Product producto = new Product(p.getNombre(), p.getCostoUnitario(),
                        p.getCantidadStock());
                productoList.add(producto);
            });

            return productoList;
        }
        return productos;
    }

    private List<Category> categoriasList;

    public List<Category> getCategorias(int codigoBodega){
        categoriasList = new ArrayList<>();
        List<Integer> codigosProductos = getProductosPorBodega(codigoBodega);

        if(!codigosProductos.isEmpty()){
            codigosProductos.forEach(e->{
                categoriasList.add(super.find(e).getCategoria());
            });
            Set<Category> categorias = new HashSet<>(categoriasList);
            categoriasList.clear();
            categorias.forEach(e->{e.setProductos(null); categoriasList.add(e);});
            return categoriasList;
        }else
            return new ArrayList<>();
    }


}
