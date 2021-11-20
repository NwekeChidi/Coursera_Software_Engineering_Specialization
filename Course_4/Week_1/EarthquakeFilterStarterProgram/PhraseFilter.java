
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter {
    
    private String where, phrase;
    
    public PhraseFilter(String phraseS, String whereF){
        where = whereF;
        phrase = phraseS;
    }
    
    public boolean satisfies(QuakeEntry qe){
        boolean check = false;
        if (where.equals("start")){
            check = qe.getInfo().indexOf(phrase) == 0;
        } else if (where.equals("end")){
            check = qe.getInfo().lastIndexOf(phrase) > -1;
        } else {
            check = qe.getInfo().indexOf(phrase) > -1;
        }
        return check;
    }
}
