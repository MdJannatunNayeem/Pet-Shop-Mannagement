package petshopmannagement;


public class MonthlyData {
    
     private int PetId;
    private String Action;
    private int Price;
    private String Date ;
    private String Month;
    
        public MonthlyData(int PetId, String Action, int Price, String  Date ,String Month) {
        this.PetId = PetId;
        this.Action = Action;
        this.Price= Price;
        this.Date=Date;
        this.Month=Month;
        
    }
       
         public int getPetId() {
        return PetId;
    }

    public String getAction() {
        return Action;
    }

    public String getDate() {
        return Date;
    }

    public int getPrice() {
        return Price;
    }

    public String getMonth() {
        return Month;
    }
}
