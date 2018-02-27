import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class profile2Comparator extends WritableComparator {

    protected profile2Comparator(){
        super(Text.class, true);
    }

    public int compare(WritableComparable w1, WritableComparable w2){
        int i1 = Integer.parseInt(w1.toString());
        int i2 = Integer.parseInt(w2.toString());
        return -1 * (i1 - i2);
    }
}
