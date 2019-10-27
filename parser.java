
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class parser {
		static List<List<String>> fullList = new ArrayList<List<String>>();

	public static void parseGTF(String fileName, String transcript_id) throws IOException {
		String path = "C:\\Users\\katen\\Documents\\GitHub\\gene-visualization\\gene vizualization\\Drosophila_melanogaster.BDGP5.77.gtf";
		Reader test = new FileReader(path);
		BufferedReader fileReader3 = new BufferedReader(test);
		String line;
		String[] cols;

		while (fileReader3.ready()) {
			line = fileReader3.readLine();
			line.toString();
			cols = line.split("\t");
			// System.out.println(Arrays.deepToString(cols));
			if (cols[8].contains(transcript_id)) {
				List<String> temp = new ArrayList<String>();
				temp.add(cols[0]);
				temp.add(cols[2]);
				temp.add(cols[3]);
				temp.add(cols[4]);
				fullList.add(temp);

		 }
		
		}
		
	System.out.println(fullList);
	 fileReader3.close();
	}
	@Override
	public String toString() {
		return "ParseSummaryStatistics [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	public List<List<String>> onlyExons() {
		List<List<String>> temp = new ArrayList<List<String>>();
		for (List<String> l1 : fullList) {
			if (l1.contains("exon")) {
				temp.add(l1);
			}
		}
		return temp;
	}
	public List<String> startCodon() {
		for (List<String> l1 : fullList) {
			if (l1.contains("start_codon")) {
				return l1;
			}
		}
		return null;
	}

	public List<String> stopCodon() {
		for (List<String> l1 : fullList) {
			if (l1.contains("stop_codon")) {
				return l1;
			}
		}
		return null;
	}
	public static void main(String[] args) throws IOException {
		parseGTF("Drosophila_melanogaster.BDGP5.77", "ABCB7-RB");

	}
}
