package tester;

public class TesterImpl implements Tester {
    @Override
    public String testen(String Wort) throws Exception {
        if(Wort == ""){
            throw new Exception();
        }
        else if(Wort == "0.0"){
            throw new Exception();
        }
        return Wort;
    }
}
