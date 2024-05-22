
package petshopmannagement;


public class SalesData {
      private int PetId;
    private String Type;
    private int Price;
    private String CustomerName ;
    private String PhoneNo;
    
        public SalesData(int PetId, String Type, int Price, String  CustomerName ,String PhoneNo) {
        this.PetId = PetId;
        this.Type = Type;
        this.Price= Price;
        this.CustomerName=CustomerName;
        this.PhoneNo=PhoneNo;
        
    }
       
         public int getPetId() {
        return PetId;
    }

    public String getType() {
        return Type;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public int getPrice() {
        return Price;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }
        
}
