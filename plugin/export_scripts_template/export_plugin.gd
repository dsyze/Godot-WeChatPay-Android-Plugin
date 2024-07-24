@tool
extends EditorPlugin

# A class member to hold the editor export plugin during its lifecycle.
var export_plugin : AndroidExportPlugin

func _enter_tree():
	# Initialization of the plugin goes here.
	export_plugin = AndroidExportPlugin.new()
	add_export_plugin(export_plugin)


func _exit_tree():
	# Clean-up of the plugin goes here.
	remove_export_plugin(export_plugin)
	export_plugin = null


class AndroidExportPlugin extends EditorExportPlugin:
	# TODO: Update to your plugin's name.
	var _plugin_name = "GodotAndroidPluginTemplate"

	func _supports_platform(platform):
		if platform is EditorExportPlatformAndroid:
			return true
		return false

	func _get_android_libraries(platform, debug):
		if debug:
			return PackedStringArray([_plugin_name + "/bin/debug/" + _plugin_name + "-debug.aar"])
		else:
			return PackedStringArray([_plugin_name + "/bin/release/" + _plugin_name + "-release.aar"])

	func _get_android_dependencies(platform: EditorExportPlatform, debug: bool):
		return PackedStringArray(["com.qq.e.union:union:4.561.1431","com.tencent.mm.opensdk:wechat-sdk-android-without-mta:+","androidx.core:core-ktx:1.9.0"])
	#				return PackedStringArray(["com.qq.e.union:union:4.561.1431","androidx.multidex:multidex:2.0.0","com.tencent.mm.opensdk:wechat-sdk-android-without-mta:+"])
	#				return PackedStringArray(["com.qq.e.union:union:4.561.1431","androidx.multidex:multidex:2.0.0","com.tencent.mm.opensdk:wechat-sdk-android-without-mta:+","androidx.legacy:legacy-support-v4:1.0.0","androidx.recyclerview:recyclerview:1.0.0","com.google.android.material:material:1.5.0","androidx.cardview:cardview:1.0.0","androidx.appcompat:appcompat:1.0.0","androidx.constraintlayout:constraintlayout:1.1.3"])
	#				return PackedStringArray(["com.squareup.okhttp3:okhttp:4.9.2","com.google.code.gson:gson:2.8.8","androidx.legacy:legacy-support-core-ui:1.0.0","com.google.android.material:material:1.5.0","com.qq.e.union:union:4.561.1431","androidx.legacy:legacy-support-v4:1.0.0","androidx.recyclerview:recyclerview:1.0.0","androidx.cardview:cardview:1.0.0","androidx.appcompat:appcompat:1.0.0","androidx.constraintlayout:constraintlayout:1.1.3","com.tencent.bugly:crashreport:latest.release","androidx.multidex:multidex:2.0.0","com.tencent.mm.opensdk:wechat-sdk-android-without-mta:+"])

	func _get_name():
		return _plugin_name
