import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class profile2ReverseOrderPartitioner extends Partitioner<profile2Object, MyComparator> {
    @Override
    public int getPartition(profile2Object key, MyComparator value, int numReducers) {
        if (numReducers == 6) {
            if (value.getArticleTitle().length() > 0) {
                Character partitionKey = value.getArticleTitle().toString().toLowerCase().charAt(0);
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

