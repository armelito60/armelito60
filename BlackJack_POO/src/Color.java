public enum Color {
	HEART("♡"),
	SPADE("♤"),
	CLUB("♣"),
	DIAMOND("♢");

	private String symbole;

	public String getSymbole() {

		return symbole;
	}

	Color(String symbole) {

		this.symbole = symbole;
	}

}


