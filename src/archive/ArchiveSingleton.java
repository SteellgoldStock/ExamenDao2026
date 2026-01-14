package archive;

public class ArchiveSingleton {
		private static ArchiveSingleton instance;
		private Archive archive;

		private ArchiveSingleton() {
				this.archive = new Archive();
		}

		public static ArchiveSingleton getInstance() {
				if (instance == null) {
						instance = new ArchiveSingleton();
				}

				return instance;
		}

		public void addOrder(String orderDetails) {
				archive.addOrder(orderDetails);
		}

		public void displayHistory() {
				archive.displayHistory();
		}
}