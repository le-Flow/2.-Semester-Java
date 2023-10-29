class Fraction {
    int nom;
    int denom;

    public Fraction(int nom, int denom){
        this.nom = nom;
        this.denom = denom;

        if(denom == 0){
            throw new IllegalArgumentException();
        }
    }

    public Fraction(Fraction f){
        this.nom = f.nom;
        this.denom = f.denom;
    }

    public void setNom(int nom){
        this.nom = nom;
    }

    public void setDenom(int denom){
        this.denom = denom;
    }

    public int getNom(){
        return this.nom;
    }

    public int getDenom(){
        return this.denom;
    }

    public Fraction normalizeSign(){
        if(this.denom < 0 && this.nom < 0){
            this.nom *= -1;
            this.denom *= -1;
        }

        if(this.denom < 0){
            this.nom *= -1;
            this.denom *= -1;
        }

        if(this.nom == 0){
            this.denom = 1;
        }
        return this;
    }

    public Fraction asReduced(){
        int gcd = gcd(Math.abs(this.nom), Math.abs(this.denom));
        this.nom = this.nom / gcd;
        this.denom = this.denom / gcd;
        return this;
    }

    private int gcd(int p, int q){
        return (q != 0? gcd(q, p % q) : p);
    }

    public double value(){
        return (double) this.nom / this.denom;
    }

    public boolean equals(Fraction f){
        return this.nom == f.nom && this.denom == f.denom;
    }

    public boolean valueEquals(Fraction f){
        return this.nom / this.denom == f.nom / f.denom;
    }
}
