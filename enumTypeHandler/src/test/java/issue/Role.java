package issue;

import org.apache.ibatis.type.Alias;

@Alias("Role")
public enum Role {

	USER(1), TECHNICAL(2), ADMIN(3);

	private int value;

	private Role(final int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * From int to Role
	 * 
	 * @param value
	 * @return
	 */
	public static Role getRoleFromValue(int value) {
		Role result = null;
		for (Role s : Role.values()) {
			if (s.getValue() == value) {
				result = s;
			}
		}
		if (result == null) {
			throw new IllegalArgumentException("No exist the Role with that value");
		}
		return result;
	}
}