package ec.edu.ups.redes;

public class Response {

    private String result;
    private boolean success;
    private  int idResponse;

    public Response(String result, boolean success, int idRespose) {
        this.result = result;
        this.success = success;
        this.idResponse = idRespose;
    }

    public String getResult() {
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getIdResponse() { return idResponse; }

}