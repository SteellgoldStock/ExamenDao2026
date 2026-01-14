public class Main {
		public static Object hashtag(String input) {
				if (input == null || input.trim().isEmpty()) {
						return false;
				}

				String[] words = input.trim().split("\\s+"); // Espaces D+F / + mot déchiré
				StringBuilder hashtag = new StringBuilder("#");

				for (String word : words) {
						if (!word.isEmpty()) {
								String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
								hashtag.append(capitalizedWord);
						}
				}

				if (hashtag.length() == 1) {
						return false;
				}

				if (hashtag.length() > 140) {
						return false;
				}

				return hashtag.toString();
		}

		public static void main(String[] args) {
				System.out.println(hashtag(" Hello there thanks for trying my Kata"));
				System.out.println(hashtag("    Hello     World   "));
				System.out.println(hashtag(""));

				System.out.println(hashtag(" ".repeat(200)));
				System.out.println(hashtag("a".repeat(139)));
				System.out.println(hashtag("a".repeat(147)));
		}
}