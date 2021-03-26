import 'dart:async';

import 'package:flutter/services.dart';

class CarouselSliderView {
  static const MethodChannel _channel =
      const MethodChannel('carousel_slider_view');
  // static const EventChannel _eventChannel =

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<String> get getBatteryLevel async {
    String batteryLevel;
    try {
      final List<dynamic> result =
          await _channel.invokeMethod('getBatteryLevel', {
        "song": ["1", "2", "3", "4"]
      });
      batteryLevel = 'Battery level at $result';
    } on PlatformException catch (e) {
      batteryLevel = "Failed to get battery level: '${e.message}'.";
    }
    return batteryLevel;
  }

  // static Future<void> _event() async {
  //   try {
  //     _eventChannel.receiveBroadcastStream();
  //   } on PlatformException catch (e) {
  //     //
  //   }
  // }
}
