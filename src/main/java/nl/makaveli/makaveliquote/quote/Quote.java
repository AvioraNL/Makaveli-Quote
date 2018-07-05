package nl.makaveli.makaveliquote.quote;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liiba
 */
public class Quote implements Comparable<Quote> {
    private final String mAuthor;
    private final String mQuote;
    private final String mCategory;

    public Quote(String author, String quote, String category) {
        mAuthor = author;
        mQuote = quote;
        mCategory = category;
    }

    public String getmAuthor() {
        return mAuthor;
    }

    public String getmQuote() {
        return mQuote;
    }

    public String getmCategory() {
        return mCategory;
    }

    @Override
    public String toString() {
        return "Quote" + "'" + mQuote + "'" +  mAuthor + "\n";
    }

    @Override
    public int compareTo(Quote t) {
      return mAuthor.compareTo(t.mAuthor);
    }
    
    
    
    
}
