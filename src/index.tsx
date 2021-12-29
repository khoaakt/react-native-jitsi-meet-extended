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
  JitsiMeetModuleIOS.call = (data: any, userInfo: any) => {
    userInfo = userInfo || {};
    call(data, userInfo);
  }
}

export { JitsiMeetExtended, JitsiMeetView, JitsiMeetModuleIOS, JitsiMeetViewIOS };