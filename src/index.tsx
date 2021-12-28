import { NativeModules, requireNativeComponent } from 'react-native';

const { JitsiMeetExtended, JitsiMeetExtendedView } = NativeModules;
const JitsiMeetView = requireNativeComponent("JitsiView");

const call = JitsiMeetExtendedView.call;
const audioCall = JitsiMeetExtendedView.audioCall;
JitsiMeetExtendedView.call = (url: any, userInfo: any) => {
  userInfo = userInfo || {};
  call(url, userInfo);
}
JitsiMeetExtendedView.audioCall = (url: any, userInfo: any) => {
  userInfo = userInfo || {};
  audioCall(url, userInfo);
}

export { JitsiMeetExtended, JitsiMeetView, JitsiMeetExtendedView };
