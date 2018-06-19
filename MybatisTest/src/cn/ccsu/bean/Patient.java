package cn.ccsu.bean;

public class Patient extends AbstractPerson {

	private String cardId;

	public Patient() {

	}

	/**
	 * @return the cardId
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * @param cardId the cardId to set
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [cardId=" + cardId + ", toString()=" + super.toString() + "]";
	}

	
}
