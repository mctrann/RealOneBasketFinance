package obr;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataReceiver dr= new DataReceiver();
//		ArrayList <Private_Investments> da= new ArrayList<Private_Investments>();
//		da.addAll(dr.getPIList());
//		for (Private_Investments p: da){
//			System.out.println(p.getLabel());
//		}
		
//		ArrayList<Assets> a = new ArrayList<Assets>();
//		a.addAll(dr.getAsset());
//		for(Assets as: a) {
//			System.out.println(as.getCode());
//		}
		
		ArrayList<Portfolios> p = new ArrayList<Portfolios>();
		p.addAll(dr.getPortfolio());
//		for(int i = 0; i < p.size(); i++) {
//			for(int j = 0; j < p.get(i).getAssetList().size(); j++) {
//				System.out.println(p.get(i).getAssetList().get(j).getCode());
//			}
//		}
		ArrayList<Portfolios> d = new ArrayList<Portfolios>();
		d.addAll(dr.getPortfolio());
		for(int i = 0; i < d.size(); i++) {
			for(int j = 0; i < d.get(i).getAssetList().size(); j++){
				if(d.get(i).getAssetList().get(j).equals("S")) {
					
					System.out.println(d.get(i).getAssetList().get(j));
				}
			}
			
		}
	}

}
