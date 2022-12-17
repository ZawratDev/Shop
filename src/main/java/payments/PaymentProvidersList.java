package payments;

import java.util.LinkedList;

public class PaymentProvidersList {
	private static PaymentProvidersList instance;
	LinkedList<PaymentProvider> providers;

	private PaymentProvidersList() {
		providers = new LinkedList<>();
		providers.add(new PaymentProvider("Google Pay", "https://pay.google.com/intl/pl_pl/about/"));
		providers.add(new PaymentProvider("Apple Pay", "https://www.apple.com/pl/apple-pay/"));
		providers.add(new PaymentProvider("Autopay Checkout", "https://autopay.pl"));
		providers.add(new PaymentProvider("PayU", "https://poland.payu.com"));
	}
}
//	public static PaymentProvidersList getInstance() {
//		if (instance == null) {
//			instance = new PaymentProvidersList();
//			return instance;
//		}
//	}
//	public void showPaymentProviders() {
//		Stream<PaymentProvidersList> providersListStream = providers.stream();
//		providersListStream.
//		providersListStream.forEach(System.out::println(s)))
//	}
//}
