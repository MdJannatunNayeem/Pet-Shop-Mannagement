
package petshopmannagement;

public class PurchaseData {
    private int PetId;
    private String Type;
    private String Variant;
    private int Price;
    private String ProviderName;
    
        public PurchaseData(int PetId, String Type, String Variant, int Price, String ProviderName) {
        this.PetId = PetId;
        this.Type = Type;
        this.Variant = Variant;
        this.Price = Price;
        this.ProviderName = ProviderName;
    }
       
         public int getPetId() {
        return PetId;
    }

    public String getType() {
        return Type;
    }

    public String getVariant() {
        return Variant;
    }

    public int getPrice() {
        return Price;
    }

    public String getProviderName() {
        return ProviderName;
    }
        
}
