import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

public class ScanData {
	Configuration conf;
	public ScanData() throws MasterNotRunningException, ZooKeeperConnectionException, IOException{
		conf=HBaseConfiguration.create();	//instantiating configuration class
	}
	
	public void display()throws IOException{
		HTable table=new HTable(conf,"company");
		Scan scan=new Scan();//instantiating the scan class
		
		//scanning the required columns
		scan.addColumn(Bytes.toBytes("details"),Bytes.toBytes("name"));
		scan.addColumn(Bytes.toBytes("details"),Bytes.toBytes("address"));
		scan.addColumn(Bytes.toBytes("details"),Bytes.toBytes("city"));
		scan.addColumn(Bytes.toBytes("details"),Bytes.toBytes("regNo"));
		//getting the scan result
		ResultScanner scanner=table.getScanner(scan);
		for(Result result=scanner.next();result!=null;result=scanner.next() )
			System.out.println("Found Now: "+result);
			scanner.close(); //close the scanner		
		
	}

	public static void main(String[] args) throws MasterNotRunningException, ZooKeeperConnectionException, IOException {
		
		ScanData sd=new ScanData();
		
		sd.display();

	}

}
