﻿// Decompiled with JetBrains decompiler
// Type: StardewValley.Monsters.SkeletonMage
// Assembly: Stardew Valley, Version=1.2.6400.27469, Culture=neutral, PublicKeyToken=null
// MVID: 77B7094A-F6F0-4ACC-91F4-E335E2733EDB
// Assembly location: D:\SteamLibrary\steamapps\common\Stardew Valley\Stardew Valley.exe

using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using StardewValley.Projectiles;
using System;
using System.Collections.Generic;
using xTile.Dimensions;

namespace StardewValley.Monsters
{
  public class SkeletonMage : Monster
  {
    private int coolDown = 1500;
    public const int visionDistance = 8;
    public const int spellCooldown = 1500;
    private bool spottedPlayer;
    private bool casting;
    private bool teleporting;
    private IEnumerator<Point> teleportationPath;
    private float rotationTimer;

    public SkeletonMage()
    {
    }

    public SkeletonMage(Vector2 position)
      : base("Skeleton Mage", position)
    {
      if (Game1.player.friendships.ContainsKey("???") && Game1.player.friendships["???"][0] >= 1250)
        this.damageToFarmer = 0;
      this.sprite.spriteHeight = 32;
    }

    public override void reloadSprite()
    {
      this.sprite = new AnimatedSprite(Game1.content.Load<Texture2D>("Characters\\Monsters\\Skeleton Mage"));
      this.sprite.spriteHeight = 32;
      this.sprite.UpdateSourceRect();
    }

    public override void draw(SpriteBatch b)
    {
      if (!this.casting)
      {
        base.draw(b);
      }
      else
      {
        b.Draw(this.Sprite.Texture, this.getLocalPosition(Game1.viewport) + new Vector2((float) (Game1.tileSize / 2 + Game1.random.Next(-8, 9)), (float) (Game1.tileSize + Game1.random.Next(-8, 9))), new Microsoft.Xna.Framework.Rectangle?(this.Sprite.SourceRect), Color.White * 0.5f, this.rotation, new Vector2(8f, 16f), Math.Max(0.2f, this.scale) * (float) Game1.pixelZoom, this.flip ? SpriteEffects.FlipHorizontally : SpriteEffects.None, Math.Max(0.0f, this.drawOnTop ? 0.991f : (float) this.getStandingY() / 10000f));
        b.Draw(this.Sprite.Texture, this.getLocalPosition(Game1.viewport) + new Vector2((float) (Game1.tileSize / 2 + Game1.random.Next(-8, 9)), (float) (Game1.tileSize + Game1.random.Next(-8, 9))), new Microsoft.Xna.Framework.Rectangle?(this.Sprite.SourceRect), Color.White * 0.5f, this.rotation, new Vector2(8f, 16f), Math.Max(0.2f, this.scale) * (float) Game1.pixelZoom, this.flip ? SpriteEffects.FlipHorizontally : SpriteEffects.None, Math.Max(0.0f, this.drawOnTop ? 0.991f : (float) (this.getStandingY() + 1) / 10000f));
        for (int index = 0; index < 8; ++index)
          b.Draw(Projectile.projectileSheet, Game1.GlobalToLocal(Game1.viewport, this.getStandingPosition()), new Microsoft.Xna.Framework.Rectangle?(new Microsoft.Xna.Framework.Rectangle(24, 92, 8, 8)), Color.White * 0.7f, this.rotationTimer + (float) ((double) index * 3.14159274101257 / 4.0), new Vector2(32f, (float) (Game1.tileSize * 4)), 1.5f, SpriteEffects.None, 0.95f);
      }
    }

    public override int takeDamage(int damage, int xTrajectory, int yTrajectory, bool isBomb, double addedPrecision)
    {
      int num = Math.Max(1, damage - this.resilience);
      if (Game1.random.NextDouble() < this.missChance - this.missChance * addedPrecision)
      {
        num = -1;
      }
      else
      {
        if (Game1.player.CurrentTool.Name.Equals("Holy Sword") && !isBomb)
        {
          this.health = this.health - damage * 3 / 4;
          Game1.currentLocation.debris.Add(new Debris(string.Concat((object) (damage * 3 / 4)), 1, new Vector2((float) this.getStandingX(), (float) this.getStandingY()), Color.LightBlue, 1f, 0.0f));
        }
        this.health = this.health - num;
        if (this.casting && Game1.random.NextDouble() < 0.5)
          this.coolDown = this.coolDown + 200;
        else if (Game1.random.NextDouble() < 0.4 + 1.0 / (double) this.health && !Game1.currentLocation.IsFarm)
        {
          this.castTeleport();
          if (this.health <= 10)
            this.speed = Math.Min(3, this.speed + 1);
        }
        else
        {
          this.setTrajectory(xTrajectory, yTrajectory);
          Game1.playSound("skeletonHit");
        }
        if (this.health <= 0)
        {
          Game1.playSound("skeletonDie");
          Game1.currentLocation.temporarySprites.Add(new TemporaryAnimatedSprite(46, this.position, Color.White, 10, false, 70f, 0, -1, -1f, -1, 0));
          Game1.currentLocation.temporarySprites.Add(new TemporaryAnimatedSprite(46, this.position + new Vector2((float) (-Game1.tileSize / 4), 0.0f), Color.White, 10, false, 70f, 0, -1, -1f, -1, 0)
          {
            delayBeforeAnimationStart = 100
          });
          Game1.currentLocation.temporarySprites.Add(new TemporaryAnimatedSprite(46, this.position + new Vector2((float) (Game1.tileSize / 4), 0.0f), Color.White, 10, false, 70f, 0, -1, -1f, -1, 0)
          {
            delayBeforeAnimationStart = 200
          });
          this.deathAnimation();
        }
      }
      return num;
    }

    public override void shedChunks(int number)
    {
      GameLocation currentLocation = Game1.currentLocation;
      Texture2D texture = this.sprite.Texture;
      Microsoft.Xna.Framework.Rectangle sourcerectangle = new Microsoft.Xna.Framework.Rectangle(0, 512, 64, 64);
      int sizeOfSourceRectSquares = 32;
      Microsoft.Xna.Framework.Rectangle boundingBox = this.GetBoundingBox();
      int x = boundingBox.Center.X;
      boundingBox = this.GetBoundingBox();
      int y1 = boundingBox.Center.Y;
      int numberOfChunks = number;
      int y2 = (int) this.getTileLocation().Y;
      Color white = Color.White;
      double num = 0.75;
      Game1.createRadialDebris(currentLocation, texture, sourcerectangle, sizeOfSourceRectSquares, x, y1, numberOfChunks, y2, white, (float) num);
    }

    public override void deathAnimation()
    {
      Game1.playSound("skeletonDie");
      int num1 = Game1.random.Next(5, 13);
      Microsoft.Xna.Framework.Rectangle boundingBox;
      for (int index = 0; index < num1; ++index)
      {
        GameLocation currentLocation = Game1.currentLocation;
        Texture2D texture = this.sprite.Texture;
        Microsoft.Xna.Framework.Rectangle sourcerectangle = new Microsoft.Xna.Framework.Rectangle(Game1.tileSize + Game1.random.Next(3) * Game1.tileSize, 512, 64, 64);
        int sizeOfSourceRectSquares = 64;
        boundingBox = this.GetBoundingBox();
        int x = boundingBox.Center.X;
        boundingBox = this.GetBoundingBox();
        int y1 = boundingBox.Center.Y;
        int numberOfChunks = 1;
        int y2 = (int) this.getTileLocation().Y;
        Color white = Color.White;
        double num2 = 1.0;
        Game1.createRadialDebris(currentLocation, texture, sourcerectangle, sizeOfSourceRectSquares, x, y1, numberOfChunks, y2, white, (float) num2);
      }
      GameLocation currentLocation1 = Game1.currentLocation;
      Texture2D texture1 = this.sprite.Texture;
      Microsoft.Xna.Framework.Rectangle sourcerectangle1 = new Microsoft.Xna.Framework.Rectangle(12, Game1.random.NextDouble() < 0.5 ? 11 : 139, 44, 41);
      int sizeOfSourceRectSquares1 = 44;
      boundingBox = this.GetBoundingBox();
      int x1 = boundingBox.Center.X;
      boundingBox = this.GetBoundingBox();
      int y3 = boundingBox.Center.Y;
      int numberOfChunks1 = 1;
      int y4 = (int) this.getTileLocation().Y;
      Color white1 = Color.White;
      double num3 = 1.0;
      Game1.createRadialDebris(currentLocation1, texture1, sourcerectangle1, sizeOfSourceRectSquares1, x1, y3, numberOfChunks1, y4, white1, (float) num3);
    }

    public void castTeleport()
    {
      int num = 0;
      Vector2 vector2;
      for (vector2 = new Vector2(this.getTileLocation().X + (Game1.random.NextDouble() < 0.5 ? (float) Game1.random.Next(-5, -1) : (float) Game1.random.Next(2, 6)), this.getTileLocation().Y + (Game1.random.NextDouble() < 0.5 ? (float) Game1.random.Next(-5, -1) : (float) Game1.random.Next(2, 6))); num < 6 && (!Game1.currentLocation.isTileOnMap(vector2) || !Game1.currentLocation.isTileLocationOpen(new Location((int) vector2.X, (int) vector2.Y)) || Game1.currentLocation.isTileOccupiedForPlacement(vector2, (StardewValley.Object) null)); ++num)
        vector2 = new Vector2(this.getTileLocation().X + (Game1.random.NextDouble() < 0.5 ? (float) Game1.random.Next(-5, -1) : (float) Game1.random.Next(2, 6)), this.getTileLocation().Y + (Game1.random.NextDouble() < 0.5 ? (float) Game1.random.Next(-5, -1) : (float) Game1.random.Next(2, 6)));
      if (num >= 6)
        return;
      this.teleporting = true;
      this.teleportationPath = Utility.GetPointsOnLine((int) this.getTileLocation().X, (int) this.getTileLocation().Y, (int) vector2.X, (int) vector2.Y, true).GetEnumerator();
      this.coolDown = 20;
    }

    public override void behaviorAtGameTick(GameTime time)
    {
      base.behaviorAtGameTick(time);
      if ((double) this.timeBeforeAIMovementAgain <= 0.0)
        this.isInvisible = false;
      if (this.teleporting)
      {
        this.coolDown = this.coolDown - time.ElapsedGameTime.Milliseconds;
        if (this.coolDown > 0)
          return;
        if (this.teleportationPath.MoveNext())
        {
          Game1.currentLocation.temporarySprites.Add(new TemporaryAnimatedSprite(this.sprite.Texture, this.sprite.SourceRect, this.position, false, 0.04f, Color.White));
          this.position = new Vector2((float) (this.teleportationPath.Current.X * Game1.tileSize + 4), (float) (this.teleportationPath.Current.Y * Game1.tileSize - Game1.tileSize / 2 - 4));
          this.coolDown = 20;
        }
        else
        {
          this.teleporting = false;
          this.coolDown = 500;
        }
      }
      else if (!this.spottedPlayer && Utility.couldSeePlayerInPeripheralVision((Character) this) && Utility.doesPointHaveLineOfSightInMine(this.getTileLocation(), Game1.player.getTileLocation(), 8))
      {
        this.controller = (PathFindController) null;
        this.spottedPlayer = true;
        this.Halt();
        this.facePlayer(Game1.player);
        if (Game1.random.NextDouble() >= 0.3)
          return;
        Game1.playSound("skeletonStep");
      }
      else if (this.casting)
      {
        this.Halt();
        this.IsWalkingTowardPlayer = false;
        TimeSpan timeSpan = time.TotalGameTime;
        this.rotationTimer = (float) ((double) timeSpan.Milliseconds * 0.0245436932891607 / 24.0 % (1024.0 * Math.PI));
        int coolDown = this.coolDown;
        timeSpan = time.ElapsedGameTime;
        int milliseconds = timeSpan.Milliseconds;
        this.coolDown = coolDown - milliseconds;
        if (this.coolDown > 0)
          return;
        this.scale = 1f;
        Vector2 velocityTowardPlayer = Utility.getVelocityTowardPlayer(this.GetBoundingBox().Center, 15f, Game1.player);
        if (Game1.player.speed >= 0 && Game1.random.NextDouble() < 0.5)
        {
          Game1.currentLocation.projectiles.Add((Projectile) new DebuffingProjectile(new Buff(19), 9, 4, 1, 0.1963495f, velocityTowardPlayer.X, velocityTowardPlayer.Y, new Vector2((float) this.GetBoundingBox().X, (float) this.GetBoundingBox().Y), (Character) null));
        }
        else
        {
          Game1.playSound("coldSpell");
          Game1.currentLocation.projectiles.Add((Projectile) new BasicProjectile(8, 8, 0, 6, 0.0f, velocityTowardPlayer.X, velocityTowardPlayer.Y, new Vector2((float) this.GetBoundingBox().X, (float) this.GetBoundingBox().Y)));
        }
        this.casting = false;
        this.coolDown = 1500;
        this.IsWalkingTowardPlayer = true;
      }
      else if (this.spottedPlayer && this.withinPlayerThreshold(8))
      {
        if (this.health < 30)
        {
          int y1 = Game1.player.GetBoundingBox().Center.Y;
          Microsoft.Xna.Framework.Rectangle boundingBox = this.GetBoundingBox();
          int y2 = boundingBox.Center.Y;
          if (Math.Abs(y1 - y2) > Game1.tileSize * 3)
          {
            boundingBox = Game1.player.GetBoundingBox();
            int x1 = boundingBox.Center.X;
            boundingBox = this.GetBoundingBox();
            int x2 = boundingBox.Center.X;
            if (x1 - x2 > 0)
              this.SetMovingLeft(true);
            else
              this.SetMovingRight(true);
          }
          else
          {
            boundingBox = Game1.player.GetBoundingBox();
            int y3 = boundingBox.Center.Y;
            boundingBox = this.GetBoundingBox();
            int y4 = boundingBox.Center.Y;
            if (y3 - y4 > 0)
              this.SetMovingUp(true);
            else
              this.SetMovingDown(true);
          }
        }
        else if (this.controller == null && !Utility.doesPointHaveLineOfSightInMine(this.getTileLocation(), Game1.player.getTileLocation(), 8))
        {
          this.controller = new PathFindController((Character) this, Game1.currentLocation, new Point((int) Game1.player.getTileLocation().X, (int) Game1.player.getTileLocation().Y), -1, (PathFindController.endBehavior) null, 300);
          if (this.controller == null || this.controller.pathToEndPoint == null || this.controller.pathToEndPoint.Count == 0)
          {
            this.spottedPlayer = false;
            this.Halt();
            this.controller = (PathFindController) null;
            this.addedSpeed = 0;
          }
        }
        else if (this.coolDown <= 0 && Game1.random.NextDouble() < 0.02)
        {
          this.casting = true;
          this.Halt();
          this.coolDown = 500;
        }
        this.coolDown = this.coolDown - time.ElapsedGameTime.Milliseconds;
      }
      else if (this.spottedPlayer)
      {
        this.IsWalkingTowardPlayer = false;
        this.spottedPlayer = false;
        this.controller = (PathFindController) null;
        this.addedSpeed = 0;
      }
      else
        this.defaultMovementBehavior(time);
    }
  }
}
