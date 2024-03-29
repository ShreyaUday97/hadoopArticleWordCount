import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class MyComparator implements WritableComparable {

    private int documentID;
    private String articleTitle;
    private String unigram;

    public MyComparator(){
        documentID = 0;
        unigram = "taco";
    }

    public MyComparator(int id, String title, String gram) {
        documentID = id;
        articleTitle = title;
        unigram = gram;
    }

    public int getDocumentID() {
        return documentID;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getUnigram() {
        return unigram;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof MyComparator) {
            MyComparator compare = (MyComparator) o;
            if(this.articleTitle.equals(compare.articleTitle) && this.documentID == compare.documentID
                    && this.unigram.equals(compare.unigram)){
                return 0;
            }
            else {
                return this.unigram.compareTo(compare.unigram) + this.documentID - compare.documentID;
            }
        }
        else{
            return -1;
        }
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(documentID);
        dataOutput.writeInt(articleTitle.length());
        dataOutput.writeBytes(articleTitle);
        dataOutput.writeInt(unigram.length());
        dataOutput.writeBytes(unigram);
    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        documentID = dataInput.readInt();
        int length = dataInput.readInt();
        byte [] buffer = new byte[length];
        dataInput.readFully(buffer,0,length);
        articleTitle = new String(buffer);
        length = dataInput.readInt();
        buffer = new byte[length];
        dataInput.readFully(buffer,0,length);
        unigram = new String(buffer);
    }

    @Override
    public String toString(){
        return documentID + "\t" + unigram;
    }

}
