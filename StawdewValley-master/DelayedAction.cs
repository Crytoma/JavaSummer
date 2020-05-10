﻿// Decompiled with JetBrains decompiler
// Type: StardewValley.DelayedAction
// Assembly: Stardew Valley, Version=1.2.6400.27469, Culture=neutral, PublicKeyToken=null
// MVID: 77B7094A-F6F0-4ACC-91F4-E335E2733EDB
// Assembly location: D:\SteamLibrary\steamapps\common\Stardew Valley\Stardew Valley.exe

using Microsoft.Xna.Framework;

namespace StardewValley
{
  public class DelayedAction
  {
    public int timeUntilAction;
    public float floatData;
    public string stringData;
    public Point pointData;
    public NPC character;
    public GameLocation location;
    public DelayedAction.delayedBehavior behavior;
    public Game1.afterFadeFunction afterFadeBehavior;
    public bool waitUntilMenusGone;
    public TemporaryAnimatedSprite temporarySpriteData;

    public DelayedAction(int timeUntilAction)
    {
      this.timeUntilAction = timeUntilAction;
    }

    public DelayedAction(int timeUntilAction, DelayedAction.delayedBehavior behavior)
    {
      this.timeUntilAction = timeUntilAction;
      this.behavior = behavior;
    }

    public bool update(GameTime time)
    {
      if (!this.waitUntilMenusGone || Game1.activeClickableMenu == null)
      {
        this.timeUntilAction = this.timeUntilAction - time.ElapsedGameTime.Milliseconds;
        if (this.timeUntilAction <= 0)
          this.behavior();
      }
      return this.timeUntilAction <= 0;
    }

    public static void warpAfterDelay(string nameToWarpTo, Point pointToWarp, int timer)
    {
      DelayedAction delayedAction = new DelayedAction(timer);
      delayedAction.behavior = new DelayedAction.delayedBehavior(delayedAction.warp);
      delayedAction.stringData = nameToWarpTo;
      delayedAction.pointData = pointToWarp;
      Game1.delayedActions.Add(delayedAction);
    }

    public static void addTemporarySpriteAfterDelay(TemporaryAnimatedSprite t, GameLocation l, int timer, bool waitUntilMenusGone = false)
    {
      DelayedAction delayedAction = new DelayedAction(timer);
      delayedAction.behavior = new DelayedAction.delayedBehavior(delayedAction.addTempSprite);
      delayedAction.temporarySpriteData = t;
      delayedAction.location = l;
      delayedAction.waitUntilMenusGone = waitUntilMenusGone;
      Game1.delayedActions.Add(delayedAction);
    }

    public static void playSoundAfterDelay(string soundName, int timer)
    {
      DelayedAction delayedAction = new DelayedAction(timer);
      delayedAction.behavior = new DelayedAction.delayedBehavior(delayedAction.playSound);
      delayedAction.stringData = soundName;
      Game1.delayedActions.Add(delayedAction);
    }

    public static void removeTemporarySpriteAfterDelay(GameLocation location, float idOfTempSprite, int timer)
    {
      DelayedAction delayedAction = new DelayedAction(timer);
      delayedAction.behavior = new DelayedAction.delayedBehavior(delayedAction.removeTemporarySprite);
      delayedAction.location = location;
      delayedAction.floatData = idOfTempSprite;
      Game1.delayedActions.Add(delayedAction);
    }

    public static void playMusicAfterDelay(string musicName, int timer)
    {
      DelayedAction delayedAction = new DelayedAction(timer);
      delayedAction.behavior = new DelayedAction.delayedBehavior(delayedAction.changeMusicTrack);
      delayedAction.stringData = musicName;
      Game1.delayedActions.Add(delayedAction);
    }

    public static void textAboveHeadAfterDelay(string text, NPC who, int timer)
    {
      DelayedAction delayedAction = new DelayedAction(timer);
      delayedAction.behavior = new DelayedAction.delayedBehavior(delayedAction.showTextAboveHead);
      delayedAction.stringData = text;
      delayedAction.character = who;
      Game1.delayedActions.Add(delayedAction);
    }

    public static void stopFarmerGlowing(int timer)
    {
      DelayedAction delayedAction = new DelayedAction(timer);
      delayedAction.behavior = new DelayedAction.delayedBehavior(delayedAction.stopGlowing);
      Game1.delayedActions.Add(delayedAction);
    }

    public static void showDialogueAfterDelay(string dialogue, int timer)
    {
      DelayedAction delayedAction = new DelayedAction(timer);
      delayedAction.behavior = new DelayedAction.delayedBehavior(delayedAction.showDialogue);
      delayedAction.stringData = dialogue;
      Game1.delayedActions.Add(delayedAction);
    }

    public static void screenFlashAfterDelay(float intensity, int timer, string sound = "")
    {
      DelayedAction delayedAction = new DelayedAction(timer);
      delayedAction.behavior = new DelayedAction.delayedBehavior(delayedAction.screenFlash);
      delayedAction.stringData = sound;
      delayedAction.floatData = intensity;
      Game1.delayedActions.Add(delayedAction);
    }

    public static void removeTileAfterDelay(int x, int y, int timer, GameLocation l, string whichLayer)
    {
      DelayedAction delayedAction = new DelayedAction(timer);
      delayedAction.behavior = new DelayedAction.delayedBehavior(delayedAction.removeBuildingsTile);
      delayedAction.pointData = new Point(x, y);
      delayedAction.location = l;
      delayedAction.stringData = whichLayer;
      Game1.delayedActions.Add(delayedAction);
    }

    public static void fadeAfterDelay(Game1.afterFadeFunction behaviorAfterFade, int timer)
    {
      DelayedAction delayedAction = new DelayedAction(timer);
      delayedAction.behavior = new DelayedAction.delayedBehavior(delayedAction.doGlobalFade);
      delayedAction.afterFadeBehavior = behaviorAfterFade;
      Game1.delayedActions.Add(delayedAction);
    }

    public void doGlobalFade()
    {
      Game1.globalFadeToBlack(this.afterFadeBehavior, 0.02f);
    }

    public void showTextAboveHead()
    {
      if (this.character == null || this.stringData == null)
        return;
      this.character.showTextAboveHead(this.stringData, -1, 2, 3000, 0);
    }

    public void addTempSprite()
    {
      if (this.location == null || this.temporarySpriteData == null)
        return;
      this.location.TemporarySprites.Add(this.temporarySpriteData);
    }

    public void stopGlowing()
    {
      Game1.player.stopGlowing();
      Game1.player.stopJittering();
      Game1.screenGlowHold = false;
      if (!Game1.isFestival() || !Game1.currentSeason.Equals("fall"))
        return;
      Game1.changeMusicTrack("fallFest");
    }

    public void showDialogue()
    {
      Game1.drawObjectDialogue(this.stringData);
    }

    public void warp()
    {
      if (this.stringData == null)
        return;
      Point pointData = this.pointData;
      Game1.warpFarmer(this.stringData, this.pointData.X, this.pointData.Y, false);
    }

    public void removeBuildingsTile()
    {
      Point pointData = this.pointData;
      if (this.location == null || this.stringData == null)
        return;
      this.location.removeTile(this.pointData.X, this.pointData.Y, this.stringData);
    }

    public void removeTemporarySprite()
    {
      if (this.location == null)
        return;
      this.location.removeTemporarySpritesWithID(this.floatData);
    }

    public void playSound()
    {
      if (this.stringData == null)
        return;
      Game1.playSound(this.stringData);
    }

    public void changeMusicTrack()
    {
      if (this.stringData == null)
        return;
      Game1.changeMusicTrack(this.stringData);
    }

    public void screenFlash()
    {
      if (this.stringData != null && this.stringData.Length > 0)
        Game1.playSound(this.stringData);
      Game1.flashAlpha = this.floatData;
    }

    public delegate void delayedBehavior();
  }
}
