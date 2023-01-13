package baiten.db;
//ふじいです＾＾このクラスは全部のゲッターとセッターのヤツです。
import java.util.Date;

public class DbInfoall {
	private int id;			//ID
	private Date date;		//日付
	private String gname;	//商品名 
	private int ko;			//個数
	private int sum;		//合計金額
	private String cust;	//顧客名
	private String user;	//担当者名
	private int price;		//価格
	private String cat;		//カテゴリー
	private int stock;		//在庫数
	private String ad;		//入学年月
	private String gen;		//性別

	protected DbInfoall(int id, Date date, String gname, int ko, int sum, String cust, String user) {//購入履歴テーブル
		setId(id);
		setDate(date);
		setGname(gname);
		setKo(ko);
		setSum(sum);
		setCust(cust);
		setUser(user);
	}

	protected DbInfoall(int id, String gname, int price, String cat) {//商品名テーブル
		setId(id);
		setGname(gname);
		setPrice(price);
		setCat(cat);
	}
	
	protected DbInfoall(String gname) {//商品名テーブルの商品名のみ表示
		setGname(gname);
	}

	protected DbInfoall(Date date, String user, String cust, String gname) {//レジテーブル
		setDate(date);
		setUser(user);
		setCust(cust);
		setGname(gname);
	}

	protected DbInfoall(int id, String gname, int stock) {//在庫数テーブル
		setId(id);
		setGname(gname);
		setStock(stock);
	}

	protected DbInfoall(int id, String ad, String cust, String gen) {//顧客名管理テーブル
		setId(id);
		setAd(ad);
		setCust(cust);
		setGen(gen);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getKo() {
		return ko;
	}

	public void setKo(int ko) {
		this.ko = ko;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String getCust() {
		return cust;
	}

	public void setCust(String cust) {
		this.cust = cust;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCat() {
		return cat;
	}

	public void setCat(String cat) {
		this.cat = cat;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}
	
	public void showInfo1() {//購入履歴テーブル
		System.out.println("id："+getId()+"　日付："+getDate()+"　商品名："+getGname()+"　個数："+getKo()+"　合計価格："+getSum()+"　購入者："+getCust()+
		"　担当者："+getUser());
	}
	
	public void showInfo2() {//商品名テーブル
		System.out.println("ID："+getId()+"　商品名："+getGname()+"　価格："+getPrice()+"円"+"　カテゴリ："+getCat());
	}
	
	public void showInfo3() {//商品名テーブルの商品名のみ
		System.out.println("商品名："+getGname());
	}
	
	public void showInfo4() {//レジテーブル
		System.out.println("日付："+getDate()+"　担当者："+getUser()+"　顧客名："+getCust()+"　商品名："+getGname());

	}
	
	public void showInfo5() {//在庫数テーブル
		System.out.println("ID："+getId()+"　商品名："+getGname()+"　在庫："+getStock());
	}
	
	public void showInfo6() {
		System.out.println("ID："+getId()+"　入学年月："+getAd()+"　購入者："+getCust()+"　性別："+getGen());
	}

}
