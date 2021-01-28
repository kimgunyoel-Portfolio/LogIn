package com.example.login.LogIn.VideiView;

import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;

public class BackgroundVideoView {

    AppCompatActivity aBackgroundVideoView;     //!< Activity
    VideoView videoView;    //!< 비디오뷰

    /**
     * 생성자
     * @param appCompatActivity
     */
    public BackgroundVideoView(AppCompatActivity appCompatActivity) {
        aBackgroundVideoView = appCompatActivity;   //!< Activity
    }

    //!< 비디오뷰 행동처리 메서드
    public void setVideoView() {
        videoView = (FullVideoView)aBackgroundVideoView.findViewById(R.id.videoview);   //!< 비디오뷰 id값 연결

        Uri uri = Uri.parse("android.resource://" + aBackgroundVideoView.getPackageName() + "/raw/login_backgound");    //!< Uri값연결
        videoView.setVideoURI(uri);     //!< 비디오뷰가 출력할 주소 설정

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {  //!< 비디오뷰 로딩준비가 끝났을때 실행
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();    //!< 비디오뷰 시작
            }
        });
        //!< 자동재생
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {  //!< 비디오뷰 재생이 끝났을때 실행
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();    //!< 비디오뷰 시작
            }
        });
    }
}
