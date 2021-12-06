public class Rational {

    int _p;
    int _q;

    public Rational () {
        _p = 1;
        _q = 1;
    }

    public Rational (int p, int q) {
        _p = p;
        _q = q;
    }

    public float floatValue() {
        return (float) _p / _q;
    }

    public String toString() {
        return _p + "/" + _q;
    }

    public void multiply (Rational rational) {
        _p = _p * rational._p;
        _q = _q * rational._q;
    }

    public void divide (Rational rational) {
        _p = _p * rational._q;
        _q = _q * rational._p;
    }

    public int gcd(int a, int b){
      if (a==b){return a;}
      else if (a>b){return gcd(a-b,b);}
      else {return gcd(b-a,a);}
    }

    public int gcd(){
      return gcd(_p,_q);
    }

    public void reduce(){
      int commonFactor = gcd();
      _p/=commonFactor;
      _q/=commonFactor;
    }

    public void add(Rational rational){
      _q = this._q*rational._q;
      _p = this._p*rational._q+this._q*rational._p;
    }

    public void subtract(Rational rational){
      _q = this._q*rational._q;
      _p = this._p*rational._q-this._q*rational._p;
    }
    public int compareTo(Rational rational){
      float floatVal = floatValue();
      float ratVal = rational.floatValue();
      if (floatVal>ratVal){
        return 1;
      } else if (floatVal==ratVal){
        return 0;
      } else {
        return -1;
      }
    }

    public static void main(String[] args) {
        Rational rat = new Rational(3, 5);
        Rational rate = new Rational(7, 4);
        Rational ratio = new Rational(10, 13);

        System.out.println(rat.floatValue());
        System.out.println(rat.toString());
        rat.multiply(rate);
        System.out.println(rat.toString());
        rat.divide(rate);
        System.out.println(rat.toString());
        System.out.println(rat.gcd());
        rat.reduce();
        System.out.println(rat.toString());
        rat.add(rate);
        System.out.println(rat.toString());
        rat.subtract(rate);
        System.out.println(rat.toString());
    }

}
