# ThreeDTouchMasterLib

This is simple library for emulating 3D Touch on Android devices with minimal API level 8

Link to Demo Android application: https://play.google.com/store/apps/details?id=com.aleksandr.miron
_______________________________________________________________________________________________

If you wont use this library you need add this code in your project

```
ThreeDTouchMaster mThreeDTouchMaster = new ThreeDTouchMaster(mListener);

...

private ThreeDTouchListener mListener = new ThreeDTouchListener() {
        @Override
        public void threeDTouch(ThreeDTouchEvent event, View view) {
            switch (event.getClickPower()) {
            case ThreeDTouchListener.NO_THREE_D_TOUCH_CLICK:
                ...
                break;
            case ThreeDTouchListener.CLICK_X2:
                ...
                break;
            case ThreeDTouchListener.CLICK_X3:
                ...
                break;
            case ThreeDTouchListener.CLICK_X4:
                ...
                break;
            case ThreeDTouchListener.CLICK_X5:
                ...
                break;
            case ThreeDTouchListener.CLICK_X6:
                ...
                break;
            case ThreeDTouchListener.CLICK_X7:
                ...
                break;
            case ThreeDTouchListener.CLICK_X8:
                ...
                break;
        }
        }
    };
```

If you want add View for handling 3D Touch you need yous this code 

```
View view = new View(getContext());//You can use all view elements

int colibTime = 150;//Colibrate time. For good working use 150 value

mThreeDTouchMaster.addViewForListening(view, colibTime);
```

Also you can remove View from ThreeDTouchMaster

```
mThreeDTouchMaster.addViewForListening(view, colibTime);
```

Also you can change colibrate time for all view elements

```
mThreeDTouchMaster.setColibTimeForAll(, colibTime);
```

or change colibrate time for necessary view

```
mThreeDTouchMaster.setColibTimeForView(view, colibTime);
```
