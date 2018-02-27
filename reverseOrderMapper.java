
import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class reverseOrderMapper extends Mapper<LongWritable, Text, Text, Text>{
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        String [] words = value.toString().split("\\t");
        if (words.length > 1)
            context.write(new Text(words[1]), new Text(words[0]));
    }
}