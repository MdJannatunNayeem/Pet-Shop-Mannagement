package petshopmannagement;

/**
 *
 * @author LENOVO
 */
public class Petdata {

    private int PetId;
    private String Type;
    private String Variant;
    private int Age;
    private String CageOrAquriumId;

    public Petdata(int PetId, String Type, String Variant, int Age, String CageOrAquriumId) {
        this.PetId = PetId;
        this.Type = Type;
        this.Variant = Variant;
        this.Age = Age;
        this.CageOrAquriumId = CageOrAquriumId;
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

    public int getAge() {
        return Age;
    }

    public String getCageOrAquriumId() {
        return CageOrAquriumId;
    }
}
