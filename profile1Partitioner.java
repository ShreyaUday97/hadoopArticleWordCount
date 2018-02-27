import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class profile1Partitioner extends Partitioner<Text, Text> {
    @Override
    public int getPartition(Text key, Text value, int numReducers) {
        if (numReducers == 6) {
            if (key.getLength() > 0) {
                Character partitionKey = key.toString().toLowerCase().charAt(0);
                if (partitionKey >= 'a' && partitionKey <= 'e')
                    return 0;
                else if (partitionKey >= 'f' && partitionKey <= 'j')
                    return 1;
                else if (partitionKey >= 'k' && partitionKey <= 'q')
                    return 2;
                else if (partitionKey >= 'r' && partitionKey <= 's')
                    return 3;
                else if (partitionKey >= 't' && partitionKey <= 'z')
                    return 4;
                else
                    return 5;
            }
        }
        return 0;
    }
}

