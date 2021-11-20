
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter {
    
    private String where, phrase, name;
    
    public PhraseFilter(String phraseS, String whereF, String title){
        where = whereF;
        phrase = phraseS;
        name = title;
    }
    
    public boolean satisfies(QuakeEntry qe){
        boolean check = false;
        if (where.equals("start")){
            check = qe.getInfo().indexOf(phrase) == 0;
        } else if (where.equals("end")){
            int toEnd = qe.getInfo().length()-phrase.length();
            check = qe.getInfo().lastIndexOf(phrase) == toEnd;
        } else {
            check = qe.getInfo().indexOf(phrase) > -1;
        }
        return check;
    }
    
    public String getName(){
        return name;
    }
}
