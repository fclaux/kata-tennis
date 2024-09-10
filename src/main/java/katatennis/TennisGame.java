package katatennis;

public class TennisGame implements Scoreable {
	
	private static final String[] SCORE_NAMES = {"Love", "Fifteen", "Thirty", "Forty"};

	private int player1Score = 0;
	private int player2Score = 0;
	private String player1Name;
	private String player2Name;

	public TennisGame(String player1Name, String player2Name) {
		this.player1Name = player1Name;
		this.player2Name = player2Name;
	}

	public void wonPoint(String playerName) {
		if (player1Name.equals(playerName))
			player1Score += 1;
		else if (player2Name.equals(playerName))
			player2Score += 1;
	}

	public String getScore() {
		String score = "";
		if (player1Score == player2Score) {
			score = getEqualScore();
		} else if (player1Score >= 4 || player2Score >= 4) {
			score = getAdvantageOrWinScore();
		} else {
			score = getNormalScore();
		}
		return score;
	}
	
	private String getEqualScore() {
		if (player1Score >= 3) {
			return "Deuce";
		}
		return SCORE_NAMES[player1Score] + "-All";
	}
	
	private String getAdvantageOrWinScore() {
		int minusResult = player1Score - player2Score;
		if (minusResult == 1)
			return "Advantage " + player1Name;
		else if (minusResult == -1)
			return "Advantage " + player2Name;
		else if (minusResult >= 2)
			return "Win for " + player1Name;
		else
			return "Win for " + player2Name;
	}
	
	private String getNormalScore() {
		 return SCORE_NAMES[player1Score] + "-" + SCORE_NAMES[player2Score];
	}
}