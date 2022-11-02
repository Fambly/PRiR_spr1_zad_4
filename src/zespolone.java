public class zespolone {
    private double zesp;
    private double rzecz;
    public zespolone(){
        zesp=0;
        rzecz=0;
    }
    public zespolone(double rzecz, double zesp){
        this.rzecz = rzecz;
        this.zesp = zesp;
    }
    public void dodaj(zespolone nextz){
        this.rzecz += nextz.rzecz;
        this.zesp += nextz.zesp;
    }
    public double modulo(){
        return Math.sqrt(Math.pow(this.rzecz,2) + Math.pow(this.zesp,2));
    }
    public zespolone prwstk()
    {
        double sq_rzecz = this.rzecz*this.rzecz - this.zesp*this.zesp;
        double sq_zesp = 2*this.rzecz*this.zesp;
        return new zespolone(sq_rzecz,sq_zesp);
    }
}
