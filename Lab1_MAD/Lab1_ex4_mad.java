class Produs {
    private String denumire;
    private double pret;

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setPret(double pret) {
        if (pret > 0) 
        {
            this.pret = pret;
        }
        else 
        {
            System.out.println("Pretul nu poate fi nr. negativ.");
        }
    }

    public double getPret() {
        return pret;
    }
}

public class Lab1_ex4_mad {
    public static void main(String[] args) {
        Produs produs = new Produs();
        produs.setDenumire("Inghetata");
        produs.setPret(25.99);

        System.out.println("Denumire: " + produs.getDenumire());
        System.out.println("Pret: " + produs.getPret());
    }
}
