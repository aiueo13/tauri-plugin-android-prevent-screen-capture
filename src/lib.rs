use tauri::{plugin::{Builder, TauriPlugin}, Runtime};

/// Initializes the plugin.
pub fn init<R: Runtime>() -> TauriPlugin<R> {
    let builder = Builder::new("android-prevent-screen-capture");

    #[cfg(target_os = "android")] 
    let builder = builder.setup(|_, api| {
        api.register_android_plugin("com.plugin.android_prevent_screen_capture", "PreventScreenCapture")?;
        Ok(())
    });

    builder.build()
}