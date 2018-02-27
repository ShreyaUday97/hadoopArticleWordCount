import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class profile2Reducer extends Reducer<MyComparator,Text,MyComparator,IntWritable>{
    public void reduce(MyComparator key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        int count = 0;
        for(Text val: values) {
            count++;
        }

        context.write(key, new IntWritable(count));
    }
}