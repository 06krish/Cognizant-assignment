package org.example.MockitoExercise1;

public class DataService {
    private ExternalApi api;
    public DataService(ExternalApi api){
        this.api = api;
    }
    public String fetchData(){
        return api.getData();
    }
}
