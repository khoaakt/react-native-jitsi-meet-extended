import { NativeModules, requireNativeComponent, Platform } from 'react-native';

const { JitsiMeetExtended } = NativeModules;
const JitsiMeetView = requireNativeComponent("JitsiView");

const isIOS = Platform.OS === 'ios';

let JitsiMeetViewIOS = null; 
let JitsiMeetModuleIOS = null; 

if (isIOS) {
  JitsiMeetViewIOS = requireNativeComponent('JitsiMeetExtendedView');;
  JitsiMeetModuleIOS = NativeModules.JitsiMeetExtendedView;
  const call = JitsiMeetModuleIOS.call;
  const audioCall = JitsiMeetModuleIOS.audioCall;
  JitsiMeetModuleIOS.call = (url: any, userInfo: any) => {
    userInfo = userInfo || {};
    call(url, userInfo);
  }
  JitsiMeetModuleIOS.audioCall = (url: any, userInfo: any) => {
    userInfo = userInfo || {};
    audioCall(url, userInfo);
  }
}

export { JitsiMeetExtended, JitsiMeetView, JitsiMeetModuleIOS, JitsiMeetViewIOS };