import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class reverseOrderReducer extends Reducer<Text,Text,Text, Text>{
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        for(Text val: values) {
            context.write(val, key);
        }

    }
}