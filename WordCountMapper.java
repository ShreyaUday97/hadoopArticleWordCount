
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, Text>{
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        if(!value.toString().isEmpty()) {

            StringTokenizer tokenizer = new StringTokenizer(value.toString().split("<====>")[2]);

            while (tokenizer.hasMoreTokens()) {
                String out = tokenizer.nextToken().replaceAll("[^A-Za-z0-9]", "").toLowerCase();
                context.write(new Text(out), new Text("one"));
            }
        }
    }
}