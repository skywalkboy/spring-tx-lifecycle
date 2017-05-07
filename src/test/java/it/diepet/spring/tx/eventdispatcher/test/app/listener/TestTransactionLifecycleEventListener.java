package it.diepet.spring.tx.eventdispatcher.test.app.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

import it.diepet.spring.tx.eventdispatcher.event.TransactionLifecycleEvent;
import it.diepet.spring.tx.eventdispatcher.test.util.StringCollector;

public class TestTransactionLifecycleEventListener<T extends TransactionLifecycleEvent<?>> implements ApplicationListener<T> {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Override
	public void onApplicationEvent(T event) {
		String msg = event.getClass().getName() + ": " + event.getTransactionInfo();
		LOGGER.info(msg);
		StringCollector.add(msg);
	}

}