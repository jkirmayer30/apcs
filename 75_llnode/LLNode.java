public class LLNode {
    private String _car;
    private LLNode _cdr;
    public LLNode(String car){
        _car = car;
    }
    public LLNode(String car,LLNode cdr){
        _car = car;
        _cdr = cdr;
    }
    public String getCar(){return _car;};

    public LLNode getCdr(){return _cdr;};
}