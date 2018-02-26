package de.gfred.feature.one

import com.mytaxi.shared.models.navigation.IFeatureOneNavigator
import com.mytaxi.shared.models.services.ITrackingService
import io.reactivex.disposables.CompositeDisposable


class MainPresenter(private val navigation: IFeatureOneNavigator,
                    private val tracker : ITrackingService) : IMainPresenter {

    private var disposables = CompositeDisposable()

    override fun create(activity: MainActivity) {
        disposables.add(activity.onButtonOneClicked().subscribe {
            tracker.track("Button One Clicked!")
            activity.showToast()
        })

        disposables.add(activity.onButtonTwoClicked().subscribe {
            tracker.track("Button Two Clicked!")
            navigation.showFeatureTwo()
        })
    }

    override fun destroy() = disposables.clear()
}