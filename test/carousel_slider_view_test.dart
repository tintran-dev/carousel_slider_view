import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:carousel_slider_view/carousel_slider_view.dart';

void main() {
  const MethodChannel channel = MethodChannel('carousel_slider_view');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await CarouselSliderView.platformVersion, '42');
  });
}
