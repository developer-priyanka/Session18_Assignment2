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

public class GetData {
	Configuration conf;
	public GetData() throws MasterNotRunningException, ZooKeeperConnectionException, IOException{
		conf=HBaseConfiguration.create();	//instantiating configuration class
	}
	
	public void getRecord() throws IOException{
		HTable table=new HTable(conf,"company");
		
		//instantiating the Get class
		Get g=new Get(Bytes.toBytes("row2"));
		//reading the data
		Result result=table.get(g);
		//reading value from result class object
		byte[]namevalue=result.getValue(Bytes.toBytes("details"), Bytes.toBytes("name"));
		byte[]addressvalue=result.getValue(Bytes.toBytes("details"),Bytes.toBytes("address"));
		byte[]cityvalue=result.getValue(Bytes.toBytes("details"),Bytes.toBytes("city"));
		byte[]regnovalue=result.getValue(Bytes.toBytes("details"),Bytes.toBytes("regNo"));
		String name=Bytes.toString(namevalue);
		String address=Bytes.toString(addressvalue);
		String city=Bytes.toString(cityvalue);
		String regno=Bytes.toString(regnovalue);
		System.out.println(name+" "+address+" "+city+" "+regno);
		
	}
	

	public static void main(String[] args) throws MasterNotRunningException, ZooKeeperConnectionException, IOException {
		
		GetData gd=new GetData();
		gd.getRecord();

	}

}
