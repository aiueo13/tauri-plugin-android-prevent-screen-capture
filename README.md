# Overview

This Tauri plugin makes your app treat the screen content as secure, ensuring it does not appear in screenshots, recordings, or on non-secure displays. This is only for Android.

# Setup

All you need to do is register this plugin with your Tauri project: 

`src-tauri/src/lib.rs`

```rust
#[cfg_attr(mobile, tauri::mobile_entry_point)]
pub fn run() {
    tauri::Builder::default()
        .plugin(tauri_plugin_android_prevent_screen_capture::init()) // This
        .run(tauri::generate_context!())
        .expect("error while running tauri application");
}
```

# License
MIT OR Apache-2.0