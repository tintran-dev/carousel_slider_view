#import "CarouselSliderViewPlugin.h"
#if __has_include(<carousel_slider_view/carousel_slider_view-Swift.h>)
#import <carousel_slider_view/carousel_slider_view-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "carousel_slider_view-Swift.h"
#endif

@implementation CarouselSliderViewPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftCarouselSliderViewPlugin registerWithRegistrar:registrar];
}
@end
