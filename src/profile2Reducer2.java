import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class profile2Reducer2 extends Reducer<profile2Object,MyComparator,MyComparator,profile2Object>{
    public void reduce(profile2Object key, Iterable<MyComparator> values, Context context) throws IOException, InterruptedException {

        for(MyComparator val: values) {
            context.write(val, key);
        }
    }
}