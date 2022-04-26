package com.example.movie_project.utilities

import rx.Subscription;
import rx.subscriptions.CompositeSubscription

class RxUtils
{
    companion object
    {
        public fun unsubscribeIfNotNull(subscription: Subscription)
        {
            if (subscription != null) {
                subscription.unsubscribe()
            }
        }

        public fun getNewCompositeSubIfUnsubscribed (compositeSubscription : CompositeSubscription) : CompositeSubscription
        {
            if (compositeSubscription == null || compositeSubscription.isUnsubscribed)
            {
                return CompositeSubscription()
            }
            return compositeSubscription
        }
    }
}